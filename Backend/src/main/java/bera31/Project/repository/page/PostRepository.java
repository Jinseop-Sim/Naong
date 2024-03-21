package bera31.Project.repository.page;

import bera31.Project.domain.page.Contents;
import bera31.Project.domain.page.groupbuying.GroupBuying;
import net.bytebuddy.description.type.TypeList;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PostRepository<T extends Contents> {
    public Long save(Contents contents);

    public Long delete(Contents contents);
    public List<T> findAll();
    public T findById(Long id);
    public List<T> findAllWithPaging(int page);
}