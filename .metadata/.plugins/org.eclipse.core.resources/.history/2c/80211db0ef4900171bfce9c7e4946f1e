package view;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;

import model.compare.CompareLine;
import model.compare.ComparedLine;
import model.compare.Line;
import model.merge.MergeLine;



public class TextViewer extends JPanel {
	private CompareLine compareline = new CompareLine();
	Text lefttext;
	Text righttext;
	private JScrollPane lefttext_scroll;
	private JScrollPane righttext_scroll;
	private ArrayList<Line> left_notcomparedlines;
	private ArrayList<Line> right_notcomparedlines;
	private ArrayList<Line> compared_left_lines;
	private ArrayList<Line> compared_right_lines;
	private Document doc;
	private MergeLine mrgline;

	private ArrayList<LineColorOffset> left_linecolorlist;
	private ArrayList<LineColorOffset> right_linecolorlist;
	int linesetcolorindex = -1;
	
	private String left_contents = "";
	private String right_contents = "";

	public TextViewer() 
	{
		super();
		mrgline = new MergeLine();
		
		setLayout(new GridLayout(1, 2, 10, 10));
		lefttext = new Text();
		lefttext.setText("Apple\nOnion\nsad\nzxcv\nasdas\nA\nzxc\n"
				+ "asdas\nA\nzxc\nasdsad\nzxczxc\nasdas\nz\na\nb\nzxc\n");
		lefttext_scroll = new JScrollPane(lefttext);
		add(lefttext_scroll);

		righttext = new Text();
		righttext.setText("Apple\nOnion\nA\nB\nC\nD\nz\n"
				+ "xc\nc\nz\na\nb\nxcvxcv\nsdfsdf\nzxxzz\n"
				+ "zx\na\n");
		righttext_scroll = new JScrollPane(righttext);
		add(righttext_scroll);
	}
	void highliteText() 
	{
		String contents;
		contents = "";

		compareline = new CompareLine();
		
		left_notcomparedlines = compareline.constructLine(lefttext);
		right_notcomparedlines = compareline.constructLine(righttext);
		compareline.matchEqualLine(left_notcomparedlines, right_notcomparedlines);

		compared_left_lines = compareline.getComparedLeft();
		compared_right_lines = compareline.getComparedRight();

		for(int i = 0; i < compared_left_lines.size(); i++)
		{
			contents += compared_left_lines.get(i).line + "\n";
		}
		lefttext.setText(contents);
		left_contents = new String(contents);
		contents = "";
		for(int i = 0; i < compared_right_lines.size(); i++)
		{
			contents += compared_right_lines.get(i).line + "\n";
		}
		righttext.setText(contents);
		right_contents = new String(contents);
		
		
		lefttext = lefttext.acceptLineColor(compared_left_lines);
		righttext = righttext.acceptLineColor(compared_right_lines);
		
		left_linecolorlist = lefttext.getLineColorList();
		right_linecolorlist = righttext.getLineColorList();
	}

	void nextDiff() throws BadLocationException 
	{
		linesetcolorindex++;
		lefttext.setText(left_contents);
		righttext.setText(right_contents);
		if (linesetcolorindex < left_linecolorlist.size()) 
		{
			lefttext.selectLineSet(linesetcolorindex);
			righttext.selectLineSet(linesetcolorindex);
		}
		else{
			linesetcolorindex = 0;
			lefttext.selectLineSet(linesetcolorindex);
			righttext.selectLineSet(linesetcolorindex);
		}
	}

	void prevDiff() throws BadLocationException 
	{
		lefttext.setText(left_contents);
		righttext.setText(right_contents);
		if (linesetcolorindex > 0) {
			linesetcolorindex--;
			lefttext.selectLineSet(linesetcolorindex);
			righttext.selectLineSet(linesetcolorindex);
		}
		else{
			linesetcolorindex = 0;
			lefttext.selectLineSet(linesetcolorindex);
			righttext.selectLineSet(linesetcolorindex);
		}
	}
	
	void firstDiff() throws BadLocationException 
	{
		lefttext.selectLineSet(0);
		righttext.selectLineSet(0);
	}
	
	void lastDiff() throws BadLocationException 
	{
		lefttext.selectLineSet(left_linecolorlist.size() - 1);
		righttext.selectLineSet(right_linecolorlist.size() - 1);
	}
	void shiftRight() throws BadLocationException
	{
		String contents = "";
		int sign = 1;
		int diff = 0;
		int length_diff = 0;
		
		int shift_start_line = left_linecolorlist.get(linesetcolorindex).getStartLine();
		int shift_end_line = left_linecolorlist.get(linesetcolorindex).getEndLine();
		int right_color_start = right_linecolorlist.get(linesetcolorindex).getColorStart();
		int right_color_end = right_linecolorlist.get(linesetcolorindex).getColorEnd();
		int left_color_start = left_linecolorlist.get(linesetcolorindex).getColorStart();
		int left_color_end = left_linecolorlist.get(linesetcolorindex).getColorEnd();
		
		System.out.println(shift_start_line + " : " + shift_end_line);
		mrgline.moveLineTo(compared_right_lines , compared_left_lines , shift_start_line, shift_end_line);
		for(int i = 0; i < compared_right_lines.size(); i++)
		{
			contents += compared_right_lines.get(i).line + "\n";
		}
		//Update Right LineColor list
		diff = (right_color_end - right_color_start) - (left_color_end - left_color_start);
		if(diff  < 0)
			diff *= -1;
		else
			diff *= -1;
		length_diff = left_color_end - left_color_start;
		right_linecolorlist.get(linesetcolorindex).setColorStart(right_color_start);
		right_linecolorlist.get(linesetcolorindex).setColorEnd(right_color_start + sign * (length_diff));
		
		right_linecolorlist.get(linesetcolorindex).setTag(ComparedLine.Tag.equal);
		left_linecolorlist.get(linesetcolorindex).setTag(ComparedLine.Tag.equal);
		
		for(int i = linesetcolorindex + 1; i < right_linecolorlist.size(); i++)
		{
			right_linecolorlist.get(i).setColorStart(right_linecolorlist.get(i).getColorStart() + (diff));
			right_linecolorlist.get(i).setColorEnd(right_linecolorlist.get(i).getColorEnd() + (diff));
			System.out.println(right_linecolorlist.get(i).getColorStart() + " @:@ " + right_linecolorlist.get(i).getColorEnd());
		}
		righttext.setLineColorOffsetArray(right_linecolorlist);
		lefttext.setLineColorOffsetArray(left_linecolorlist);
		
		righttext.setText(contents);
		right_contents = new String(contents);
		
		righttext.selectLineSet(linesetcolorindex);
		lefttext.selectLineSet(linesetcolorindex);
		//Remove Operation
		right_linecolorlist.remove(linesetcolorindex);
		left_linecolorlist.remove(linesetcolorindex);
		righttext.setLineColorOffsetArray(right_linecolorlist);
		lefttext.setLineColorOffsetArray(left_linecolorlist);
		if(linesetcolorindex >= 0){
			linesetcolorindex--;
		}
	}
	void shiftLeft() throws BadLocationException
	{
		String contents = "";
		int sign = 1;
		int diff = 0;
		int length_diff = 0;
		
		int shift_start_line = right_linecolorlist.get(linesetcolorindex).getStartLine();
		int shift_end_line = right_linecolorlist.get(linesetcolorindex).getEndLine();
		int right_color_start = right_linecolorlist.get(linesetcolorindex).getColorStart();
		int right_color_end = right_linecolorlist.get(linesetcolorindex).getColorEnd();
		int left_color_start = left_linecolorlist.get(linesetcolorindex).getColorStart();
		int left_color_end = left_linecolorlist.get(linesetcolorindex).getColorEnd();
		
		System.out.println(shift_start_line + " : " + shift_end_line);
		mrgline.moveLineTo(compared_left_lines , compared_right_lines , shift_start_line, shift_end_line);
		for(int i = 0; i < compared_left_lines.size(); i++)
		{
			contents += compared_left_lines.get(i).line + "\n";
		}
		//Update Left LineColor list
		diff = (left_color_end - left_color_start) - (right_color_end - right_color_start);
		if(diff  < 0)
			diff *= -1;
		else
			diff *= -1;
		length_diff = right_color_end - right_color_start;
		left_linecolorlist.get(linesetcolorindex).setColorStart(left_color_start);
		left_linecolorlist.get(linesetcolorindex).setColorEnd(left_color_start + sign * (length_diff));
		
		right_linecolorlist.get(linesetcolorindex).setTag(ComparedLine.Tag.equal);
		left_linecolorlist.get(linesetcolorindex).setTag(ComparedLine.Tag.equal);
		
		for(int i = linesetcolorindex + 1; i < left_linecolorlist.size(); i++)
		{
			left_linecolorlist.get(i).setColorStart(left_linecolorlist.get(i).getColorStart() + (diff));
			left_linecolorlist.get(i).setColorEnd(left_linecolorlist.get(i).getColorEnd() + (diff));
		}
		righttext.setLineColorOffsetArray(right_linecolorlist);
		lefttext.setLineColorOffsetArray(left_linecolorlist);
		
		lefttext.setText(contents);
		left_contents = new String(contents);
		
		righttext.selectLineSet(linesetcolorindex);
		lefttext.selectLineSet(linesetcolorindex);
		
		//Remove Operation
		right_linecolorlist.remove(linesetcolorindex);
		left_linecolorlist.remove(linesetcolorindex);
		righttext.setLineColorOffsetArray(right_linecolorlist);
		lefttext.setLineColorOffsetArray(left_linecolorlist);
		if(linesetcolorindex >= 0){
			linesetcolorindex--;
		}
	}
	public Text getLefttext(){ return lefttext; }
	public Text getRighttext(){ return righttext; }
}
