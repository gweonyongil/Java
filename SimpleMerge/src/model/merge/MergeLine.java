package model.merge;

import java.util.ArrayList;

import model.compare.Line;

public class MergeLine implements MrgLine{
	public void moveLineTo(ArrayList<Line> dest_contents, ArrayList<Line> src_contents, int start_line, int end_line)
	{
		for(int i = 0; i < dest_contents.size(); i ++){
			System.out.println((dest_contents.get(i).line));
		}
		for(int i = 0 ; i < src_contents.size(); i++){
			System.out.println(src_contents.get(i).line);
		}
		for(int i = start_line; i <= end_line; i++)
		{
			dest_contents.get(i).line = src_contents.get(i).line;
			System.out.println(dest_contents.get(i).line);
		}
		System.out.println(dest_contents.get(0).line);
	}
}
