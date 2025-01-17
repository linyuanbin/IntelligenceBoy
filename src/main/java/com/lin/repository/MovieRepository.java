package com.lin.repository;


import com.lin.node.Movie;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends GraphRepository<Movie>{
	 List<Movie> findByTitle(@Param("title") String title);
	 @Query("match(n:Person)-[:actedin]->(m:Movie) where n.name='章子怡' return m.title")
	 List<String> getMovieTiles();
}
