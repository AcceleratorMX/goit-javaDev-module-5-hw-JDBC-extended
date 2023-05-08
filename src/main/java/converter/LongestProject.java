package converter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LongestProject {
    private Integer id;
    private int monthCount;

    @Override
    public String toString() {
        return "id=" + id + " | monthCount=" + monthCount;
    }
}
