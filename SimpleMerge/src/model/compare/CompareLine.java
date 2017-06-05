package model.compare;

import java.util.ArrayList;

import javax.swing.JTextPane;

import model.compare.ComparedLine.Tag;

public class CompareLine implements CmpLine{

	private ArrayList<Line> compared_left = new ArrayList<Line>();
	private ArrayList<Line> compared_right = new ArrayList<Line>();
	
	@Override
	public ArrayList<Line> constructLine(JTextPane text_pane) {
		// TODO Auto-generated method stub
		
		ArrayList<Line> contents = new ArrayList<Line>();
		
		String[] contents_str = text_pane.getText().split("\n");
		for(String str : contents_str){
			NotComparedLine line = new NotComparedLine(str);
			contents.add(line);
		}
		
		return contents;
	}

	@Override
	public void matchEqualLine(ArrayList<Line> notCompared_left, ArrayList<Line> notCompared_right) {
		// TODO Auto-generated method stub
		
		NotComparedLine start_line = new NotComparedLine("");
		notCompared_left.add(0, start_line);
		notCompared_right.add(0, start_line);
		
		int left_size = notCompared_left.size();
		int right_size = notCompared_right.size();
		
		int LCS_count = 0;
		int max_matching_count;
		int[][] table = new int[right_size][left_size];
		
		for(int i = 0; i < left_size; i++){
			table[0][i] = 0;
		}
		
		//Calculation Table Index and LCS Count
		for(int i = 1; i < right_size; i++){
			max_matching_count = 0;
			table[i][0] = 0;
			for(int j = 1; j < left_size; j++){
				System.out.println(i + ")" + notCompared_right.get(i).line + " : " + j + ")" + notCompared_left.get(j).line);
				if(notCompared_right.get(i).line.equals(notCompared_left.get(j).line)){
					max_matching_count = table[i-1][j-1] + 1;
					table[i][j] = max_matching_count;
				}
				else{
					if(table[i][j-1] > table[i-1][j])
						table[i][j] = table[i][j-1];
					else
						table[i][j] = table[i-1][j];
				}
			}
			if(LCS_count < max_matching_count)
				LCS_count = max_matching_count;
		}
		
		//Match line positions of left contents and right contents
		ComparedLine compared_left_line;
		ComparedLine compared_right_line;
		
		ComparedLine blank_line = new ComparedLine("");
		blank_line.tag = Tag.space;
		
		int matching_line_count = 0;
		int matching_left_index = 0;
		int matching_right_index = 0;
		
		int left_count, right_count;
		int left_print_count = 0;
		int	right_print_count = 0;
		
		//Calculation LCS
		
		for(int j = 1; j < left_size; j ++){
			for(int i = matching_right_index + 1; i < right_size; i ++){
				if(table[i][j] == matching_line_count + 1){
					left_count = j - matching_left_index;
					right_count = i - matching_right_index;
					
					for(int num = 1; num < left_count; num ++){
						compared_left_line = new ComparedLine(notCompared_left.get(matching_left_index + num).line);
						compared_left_line.tag = Tag.notequal;
						compared_left.add(compared_left_line);
						left_print_count++;
					}
					for(int num = 1; num < right_count; num ++){
						compared_right_line = new ComparedLine(notCompared_right.get(matching_right_index + num).line);
						compared_right_line.tag = Tag.notequal;
						compared_right.add(compared_right_line);
						right_print_count++;
					}
					
					if(left_count - right_count == 0){						
						//null
					}
					else if(left_count - right_count > 0){
						for(int num = 0; num < left_count - right_count; num ++){
							compared_right.add(blank_line);
						}
					}
					//left_count - right_count < 0
					else{
						for(int num = 0; num < right_count - left_count; num ++){
							compared_left.add(blank_line);
						}
					}
					compared_left_line = new ComparedLine(notCompared_left.get(j).line);
					compared_left_line.tag = Tag.equal;
					compared_left.add(compared_left_line);
					left_print_count++;
					
					compared_right_line = new ComparedLine(notCompared_right.get(i).line);
					compared_right_line.tag = Tag.equal;
					compared_right.add(compared_right_line);
					right_print_count++;
					
					matching_line_count++;
					matching_left_index = j;
					matching_right_index = i;
					
					break;
				}
				
			}
		}
		
		if(left_print_count < notCompared_left.size()){
			for(int i = left_print_count+1; i < notCompared_left.size(); i ++){
				compared_left_line = new ComparedLine(notCompared_left.get(i).line);
				compared_left_line.tag = Tag.notequal;
				compared_left.add(compared_left_line);
			}
		}
		if(right_print_count < notCompared_right.size()){
			for(int i = right_print_count+1; i < notCompared_right.size(); i ++){
				compared_right_line = new ComparedLine(notCompared_right.get(i).line);
				compared_right_line.tag = Tag.notequal;
				compared_right.add(compared_right_line);
			}
		}
	}
	
	public ArrayList<Line> getComparedLeft(){
		  for(Line str : compared_left){
			  ComparedLine cstr = (ComparedLine)str;
	    	  System.out.println("*" + cstr.tag + str.line);
	      }
		return compared_left;
	}
	
	public ArrayList<Line> getComparedRight(){
		return compared_right;
	}

}
