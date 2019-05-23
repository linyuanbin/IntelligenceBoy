package com.lin;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.Segment;
import com.hankcs.hanlp.seg.common.Term;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MachineApplicationTests {

	@Test
	public void contextLoads() {
		Segment segment = HanLP.newSegment().enableCustomDictionary(true);
		List<Term> terms = segment.seg("周星驰的一生中一共参演过多少部电影");
		System.out.println("分词结果如下：");
		for (Term term : terms) {
			System.out.println(term.word+" "+term.nature);
		}
	}

}
