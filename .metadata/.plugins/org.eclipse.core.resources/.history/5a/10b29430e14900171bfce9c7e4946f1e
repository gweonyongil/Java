package model.compare.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.swing.JTextPane;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import model.compare.CmpLine;
import model.compare.CompareLine;
import model.compare.Line;

public class CompareConstructTest {	
	
	CompareLine compare_line;
	
	CmpLine cmp_line;
	
	ArrayList<Line> test_left_list;
	ArrayList<Line> test_right_list;
	
	@Before
	public void setUp(){
		compare_line = new CompareLine();
	}
	
	@Test
	public void testConstructLine() {
		
		JTextPane test_left_pane = new JTextPane();
		test_left_pane.setText("ab\ncd\nef\ngh\n");
		
		JTextPane test_right_pane = new JTextPane();
		test_right_pane.setText("ab\ncd\nNOT_EQUAL\ngh\n");
		
		test_left_list = compare_line.constructLine(test_left_pane);
		assertNotNull(test_left_list);
		
		test_right_list = compare_line.constructLine(test_right_pane);
		assertNotNull(test_right_list);
		
		assertNotEquals(test_left_list.get(2), test_right_list.get(2));	
		
	}
	
	@Test
	public void testStartOfListValue(){
		JTextPane test_left_pane = new JTextPane();
		test_left_pane.setText("ab\ncd\nef\ngh\n");
		test_left_list = compare_line.constructLine(test_left_pane);
		
		assertEquals("ab", test_left_list.get(0).line);
	}
	
	@Test
	public void testMiddleOfListValue(){
		JTextPane test_left_pane = new JTextPane();
		test_left_pane.setText("ab\ncd\nef\ngh\n");
		test_left_list = compare_line.constructLine(test_left_pane);
		
		assertEquals("ef", test_left_list.get(2).line);
	}
	
	@Test
	public void testEndOfListValue(){
		JTextPane test_left_pane = new JTextPane();
		test_left_pane.setText("ab\ncd\nef\ngh\n");
		test_left_list = compare_line.constructLine(test_left_pane);
		
		assertEquals("gh", test_left_list.get(3).line);
	}
	

}
