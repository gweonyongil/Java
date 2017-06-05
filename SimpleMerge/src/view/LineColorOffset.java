package view;

import model.compare.ComparedLine;

public class LineColorOffset {
	private int color_start;
	private int color_end = 0;
	private int start_line;
	private int end_line;
	ComparedLine.Tag tag;
		
	public LineColorOffset(int color_start)
	{
		this.color_start = color_start;
	}
	public int getStartLine(){ return start_line; }
	public int getEndLine(){ return end_line; }
	public void setStartLine(int start_line)
	{
		this.start_line = start_line;
	}
	public void setEndLine(int end_line)
	{
		this.end_line = end_line;
	}
	public void setColorStart(int color_start)
	{
		this.color_start = color_start;
	}
	public void setColorEnd(int color_end)
	{
		this.color_end = color_end;
	}
	public int getColorStart()
	{
		return color_start;
	}
	public int getColorEnd() 
	{
		return color_end;
	}
	public void setTag(ComparedLine.Tag tag)
	{ 
		this.tag = tag; 
	}
	public ComparedLine.Tag getTag()
	{
		return tag;
	}
}
