package tables;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Project {
    private Integer client_id;
    private String start_date;
    private String finish_date;
}
