package model.merge;

import java.util.ArrayList;

import model.compare.ComparedLine;
import model.compare.Line;

public class MergeLine implements MrgLine{
	public void moveLineTo(ArrayList<Line> dest_contents, ArrayList<Line> src_contents, int start_line, int end_line)
	{
		for(int i = start_line; i <= end_line; i++)
		{
			ComparedLine line = new ComparedLine(src_contents.get(i).line);
			dest_contents.set(i, line);
		}
	}
}
