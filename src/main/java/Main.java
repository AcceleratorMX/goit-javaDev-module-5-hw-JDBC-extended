
public class Main {
    public static void main(String[] args) {
        DatabaseQueryService databaseQueryService = new DatabaseQueryService();

        System.out.println("Longest Project:" + "\n" + databaseQueryService.findLongestProject() + "\n");
        System.out.println("Max Project Client:" + "\n" + databaseQueryService.findMaxProjectClient() + "\n");
        System.out.println("Max Salary Worker:" + "\n" + databaseQueryService.findMaxSalaryWorker() + "\n");
        System.out.println("Youngest/Eldest Workers:" + "\n" + databaseQueryService.findYoungestEldestWorkers() + "\n");
        System.out.println("Project Price:" + "\n" + databaseQueryService.findProjectPrices() + "\n");
    }
}