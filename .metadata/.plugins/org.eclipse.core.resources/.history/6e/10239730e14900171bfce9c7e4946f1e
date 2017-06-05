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
		
		/*left_list.add(new NotComparedLine("Apple"));
		left_list.add(new NotComparedLine("Onion"));
		left_list.add(new NotComparedLine("A"));
		left_list.add(new NotComparedLine("B"));
		left_list.add(new NotComparedLine("C"));
		left_list.add(new NotComparedLine("D"));*/
		
		left_list.add(new NotComparedLine("A"));
		left_list.add(new NotComparedLine("C"));
		left_list.add(new NotComparedLine("A"));
		left_list.add(new NotComparedLine("Y"));
		left_list.add(new NotComparedLine("K"));
		left_list.add(new NotComparedLine("P"));
		
		right_list = new ArrayList<Line>();
		
		/*right_list.add(new NotComparedLine("A"));
		right_list.add(new NotComparedLine("B"));
		right_list.add(new NotComparedLine("asdfsadf"));
		right_list.add(new NotComparedLine("sasgeae"));
		right_list.add(new NotComparedLine("a"));
		right_list.add(new NotComparedLine("z"));*/
		
		right_list.add(new NotComparedLine("C"));
		right_list.add(new NotComparedLine("A"));
		right_list.add(new NotComparedLine("P"));
		right_list.add(new NotComparedLine("C"));
		right_list.add(new NotComparedLine("A"));
		right_list.add(new NotComparedLine("K"));
		assertNotEquals(left_list, right_list);
	}
	
	@Test
	public void testMatchEqualLine() {
		compare_line.matchEqualLine(left_list, right_list);
		ArrayList<Line> compared_left_list;
		ArrayList<Line> compared_right_list;
		
		ComparedLine compared_line;
		
		compared_left_list = compare_line.getComparedLeft();
		compared_right_list = compare_line.getComparedRight();
		
		System.out.println("//¿ÞÂÊ//");
		for(Line str : compared_left_list){
			compared_line = (ComparedLine)str;
			System.out.println("* " + "<" + compared_line.tag + ">" + compared_line.line);
		}
		
		System.out.println("//¿À¸¥ÂÊ//");
		for(Line str : compared_right_list){
			compared_line = (ComparedLine)str;
			System.out.println("* " + "<" + compared_line.tag + ">" + compared_line.line);
		}
		
		assertEquals(compared_left_list.size(), compared_right_list.size());
		assertNotEquals(compared_left_list, compared_right_list);		
	}

}
