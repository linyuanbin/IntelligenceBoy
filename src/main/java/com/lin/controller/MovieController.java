package com.lin.controller;


import com.lin.node.Movie;
import com.lin.repository.MovieRepository;
import com.lin.result.ResponseMessage;
import com.lin.result.ResponseResult;
import com.lin.result.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/appleyk/movie") //restful风格的api接口
public class MovieController {
   
	@Autowired
	MovieRepository movieRepository;
      
	/**
	 * 根据电影名查询电影实体
	 * @param title
	 * @return
	 */
    @RequestMapping("/get")
    public List<Movie> getMovies(@RequestParam(value="title") String title){
    	return movieRepository.findByTitle(title);
    }

	/**
	 * 创建一个电影节点
	 *
	 * @param movie
	 * @return
	 */
	@PostMapping("/save")
    public ResponseResult saveMovie(@RequestBody Movie movie){
    	movieRepository.save(movie);
    	return new ResponseResult(ResponseMessage.OK);
    }  
	
    
    @RequestMapping("/query")
    public ResponseResult queryMovieTiles(){      	
    	List<String> movieTiles = movieRepository.getMovieTiles();
    	ResultData<String> result = new ResultData<String>(ResponseMessage.OK, movieTiles);
    	return new ResponseResult(result);
    } 
}
