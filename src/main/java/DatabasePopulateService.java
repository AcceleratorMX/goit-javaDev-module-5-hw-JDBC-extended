import tables.Client;
import tables.Project;
import tables.ProjectWorker;
import tables.Worker;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class DatabasePopulateService {
    private static final String WORKER = "sqlJson/worker.json";
    private static final String CLIENT = "sqlJson/client.json";
    private static final String PROJECT = "sqlJson/project.json";
    private static final String PROJECT_WORKER = "sqlJson/project_worker.json";
    private static PreparedStatement preparedStatement;
    private final Connection connection = Database.getInstance().getConnection();

    public static void main(String[] args) {
        DatabasePopulateService databasePopulateService = new DatabasePopulateService();
        databasePopulateService.workerAdd();
        databasePopulateService.clientAdd();
        databasePopulateService.projectAdd();
        databasePopulateService.projectWorkerAdd();
    }

    public <T> List<T> reader(Class<T> entityClass, String filePath) {
        List<T> jsonList = new ArrayList<>();
        try (FileReader fileReader = new FileReader(filePath)) {
            Type type = TypeToken.getParameterized(List.class, entityClass).getType();
            jsonList = new Gson().fromJson(fileReader, type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonList;
    }

    public void workerAdd() {
        List<Worker> workers = reader(Worker.class, WORKER);
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO worker (name, birthday, level, salary) VALUES (?, ?, ?, ?)");
            workers.forEach(worker -> {
                try {
                    preparedStatement.setString(1, worker.getName());
                    preparedStatement.setString(2, worker.getBirthday());
                    preparedStatement.setString(3, worker.getLevel());
                    preparedStatement.setInt(4, worker.getSalary());
                    preparedStatement.addBatch();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
            preparedStatement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void clientAdd() {
        List<Client> clients = reader(Client.class, CLIENT);
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO client (name) VALUES (?)");
            clients.forEach(client -> {
                try {
                    preparedStatement.setString(1, client.getName());
                    preparedStatement.addBatch();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
            preparedStatement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void projectAdd() {
        List<Project> projects = reader(Project.class, PROJECT);
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO project (client_id, start_date, finish_date) VALUES (?, ?, ?)");
            projects.forEach(project -> {
                try {
                    preparedStatement.setInt(1, project.getClient_id());
                    preparedStatement.setString(2,project.getStart_date());
                    preparedStatement.setString(3,project.getFinish_date());
                    preparedStatement.addBatch();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
            preparedStatement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void projectWorkerAdd() {
        List<ProjectWorker> projectWorkers = reader(ProjectWorker.class, PROJECT_WORKER);
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO project_worker (project_id , worker_id) VALUES (?, ?)");
            projectWorkers.forEach(project -> {
                try {
                    preparedStatement.setInt(1, project.getProject_id());
                    preparedStatement.setInt(2, project.getWorker_id());
                    preparedStatement.addBatch();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
            preparedStatement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

