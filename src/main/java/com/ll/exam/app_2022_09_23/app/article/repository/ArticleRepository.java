package com.ll.exam.app_2022_09_23.app.article.repository;

import com.ll.exam.app_2022_09_23.app.article.dto.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ArticleRepository {

    @Select("""
            <script>
            SELECT *
            FROM article
            </script>
            """)
    List<Article> getArticles();

    @Insert("""
            <script>
            INSERT INTO article
            SET createDate = NOW(),
            modifyDate = NOW(),
            subject = #{subject},
            content = #{content}
            </script>
            """)
    void write(@Param("subject") String subject, String content);

    @Select("""
            SELECT LAST_INSERT_ID()
            """)
    public long getLastInsertId();

    @Select("""
            <script>
            SELECT *
            FROM article
            WHERE id = #{id}
            </script>
            """)
    Article getArticleById(long id);


    @Select("""
			<script>
			SELECT A.*
			FROM article AS A
			WHERE 1
			<if test="kw != ''">
			AND A.subject LIKE CONCAT('%', #{kw}, '%')
			</if>
			</script>
			""")
    List<Article> search(String kwType, String kw);
}
