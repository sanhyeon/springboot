package com.example.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.domain.BoardVO;

public interface QueryAnnoRepository extends CrudRepository<BoardVO, Integer>{

   // [1] JPQL (복잡한 쿼리문 사용 시) SQL문장 아님 주의 !! 
   @Query("SELECT b FROM BoardVO b WHERE b.title LIKE %?1% ORDER BY b.seq DESC")
   List<BoardVO> queryAnnotation(String word);
   
   // [2] SQL (복잡한 쿼리)
   @Query(value="SELECT * FROM board where title Like '%'||?1||'%' ORDER BY seq DESC", nativeQuery=true)
   List<BoardVO> queryAnnotation2(String word);
   
   // [2] SQL (복잡한 쿼리)
   // board2와 board_file
   // 레코드 리턴값 BoardVO 안 나옴 -> Object[] / HashMap 등으로 실행
   @Query(value="SELECT FROM board2 inner join title Like '%'||?1||'%' ORDER BY seq DESC", nativeQuery=true)
   List<BoardVO> queryAnnotation3(String word);
}
