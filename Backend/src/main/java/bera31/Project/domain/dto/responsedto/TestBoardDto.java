package bera31.Project.domain.dto.responsedto;
import bera31.Project.domain.TestBoard;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class TestBoardDto {
    private int id;
    private String title;
    private String author;

    public TestBoardDto(TestBoard testBoard){
        this.id = testBoard.getId();
        this.title = testBoard.getTitle();
        this.author = testBoard.getAuthor();
    }
}
