package model.compare.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import javax.swing.JTextPane;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import model.compare.CompareLine;
import model.compare.ComparedLine;
import model.compare.Line;
import model.compare.NotComparedLine;

public class CompareMatchEqualTest {

	CompareLine compare_line;
	ArrayList<Line> left_list;
	ArrayList<Line> right_list;
	
	@Before
	public void setUp(){
		compare_line = new CompareLine();
		left_list = new ArrayList<Line>();
		Line line;
		
		for(int i = 0; i < 4; i ++){
			line = new NotComparedLine("num " + i);
			left_list.add(line);
		}		
		
		right_list = new ArrayList<Line>();
		
		Line blank_line = new NotComparedLine("");
		right_list.add(blank_line);
		for(int i = 0; i < 4; i ++){
			line = new NotComparedLine("num " + i);
			right_list.add(line);
		}	
		
		assertNotEquals(left_list, right_list);
	}
	
	@Test
	public void testMatchEqualLine() {
		compare_line.matchEqualLine(left_list, right_list);
		ArrayList<Line> compared_left_list;
		ArrayList<Line> compared_right_list;
		
		compared_left_list = compare_line.getComparedLeft();
		compared_right_list = compare_line.getComparedRight();
		
		for(Line str : compared_left_list){
			System.out.println(str.line);
		}
		
		for(Line str : compared_right_list){
			System.out.println(str.line);
		}
		
		assertEquals(compared_left_list.size(), compared_right_list.size());
		assertNotEquals(compared_left_list, compared_right_list);		
	}

}
