package mul.cam.e.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BbsPram {
    private String category;
    private String keyword;
    private int pageNumber;
}
