package view;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;

import controller.textviewer.TextViewerMergeController;
import controller.textviewer.TextViewerSearchController;
import model.compare.CompareLine;
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
	private TextViewerSearchController tvscontroller;
	private TextViewerMergeController tvmcontroller;

	private ArrayList<LineColorOffset> left_linecolorlist;
	private ArrayList<LineColorOffset> right_linecolorlist;
	int linesetcolorindex = -1;
	int shift_flag = 0;
	
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
		
		tvscontroller = new TextViewerSearchController(lefttext, righttext, this);
		tvmcontroller = new TextViewerMergeController(lefttext, righttext, this);
		
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
		if(shift_flag == 0)
			linesetcolorindex++;
		tvscontroller.nextDiff(linesetcolorindex, left_linecolorlist.size(), left_contents, right_contents);
		shift_flag = 0;
	}

	void prevDiff() throws BadLocationException 
	{
		linesetcolorindex--;
		tvscontroller.prevDiff(linesetcolorindex, left_linecolorlist.size(), left_contents, right_contents);
		shift_flag = 0;
	}
	
	void firstDiff() throws BadLocationException 
	{
		tvscontroller.firstDiff(left_contents, right_contents);
		/*lefttext.setText(left_contents);
		righttext.setText(right_contents);
		lefttext.selectLineSet(0);
		righttext.selectLineSet(0);*/
	}
	
	void lastDiff() throws BadLocationException 
	{
		tvscontroller.lastDiff(left_linecolorlist.size(), left_contents, right_contents);
	}
	void shiftRight() throws BadLocationException
	{
		tvmcontroller.shiftRight(linesetcolorindex, left_contents, left_linecolorlist, right_linecolorlist, compared_left_lines, compared_right_lines);
		shift_flag = 1;
	}
	void shiftLeft() throws BadLocationException
	{
		tvmcontroller.shiftRight(linesetcolorindex, left_contents, left_linecolorlist, right_linecolorlist, compared_left_lines, compared_right_lines);
		shift_flag = 1;
	}
	public void setlinesetcolorindex(int linesetcolorindex){
		this.linesetcolorindex = linesetcolorindex;
	}
	public void setLeftContent(String left_contents)
	{
		this.left_contents = left_contents;
	}
	public void setRightContent(String right_contents)
	{
		this.right_contents = right_contents;
	}
	public Text getLefttext(){ return lefttext; }
	public Text getRighttext(){ return righttext; }
}