package zerobase.weather;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import zerobase.weather.domain.Memo;
import zerobase.weather.repository.JpaMemoRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class JpaMemoRepositoryTest {


    @Autowired
    JpaMemoRepository jpaMemoRepository;


    @Test
    void findAllMemoTest(){
        List<Memo> memoList = jpaMemoRepository.findAll();
        System.out.println(memoList);
        assertNotNull(memoList);
    }

    @Test
    void insertMemoTest(){

        Memo newMemo = new Memo(1,"hi~ this is new memo~");

        jpaMemoRepository.save(newMemo);

        List<Memo> memoList = jpaMemoRepository.findAll();
        assertTrue(memoList.size()>0);
    }
}
