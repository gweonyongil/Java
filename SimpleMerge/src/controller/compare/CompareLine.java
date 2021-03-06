package controller.compare;

import java.util.ArrayList;

import javax.swing.JTextPane;

import controller.compare.ComparedLine.Tag;

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
		int left_size = notCompared_left.size() + 1;
		int right_size = notCompared_right.size() + 1;
		
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
				if(notCompared_left.get(i).equals(notCompared_right.get(j))){
					max_matching_count = table[i-1][j-1] + 1;
					table[i][j] = max_matching_count;
				}
				else{
					if(table[i][j-1] > table[i][j])
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
		
		ComparedLine blank_line = new ComparedLine("\n");
		blank_line.tag = Tag.space;
		
		int matching_line_count = 0;
<<<<<<< HEAD
=======
		int matching_left_index = 1;
		int matching_right_index = 1;
		
		int left_count, right_count;
		
		for(int j = matching_left_index; j < left_size; j ++){
			for(int i = matching_right_index; i < right_size; i ++){
				if(table[i][j] == matching_line_count + 1){
					left_count = j - matching_left_index;
					right_count = i - matching_right_index;
					
					for(int num = matching_left_index+1; num < j; num ++){
						compared_left_line = new ComparedLine(notCompared_left.get(num).line);
						compared_left_line.tag = Tag.notequal;
						compared_left.add(compared_left_line);
					}
					for(int num = matching_right_index+1; num < i; num ++){
						compared_right_line = new ComparedLine(notCompared_right.get(num).line);
						compared_right_line.tag = Tag.notequal;
						compared_right.add(compared_right_line);
					}
					
					if(left_count - right_count == 0){						
						//null
					}
					else if(left_count - right_count > 0){
						for(int num = 1; num < left_count - right_count; num ++){
							compared_right.add(blank_line);
						}
					}
					//left_count - right_count < 0
					else{
						for(int num = 1; num < right_count - left_count; num ++){
							compared_left.add(blank_line);
						}
					}
					compared_left_line = new ComparedLine(notCompared_left.get(j).line);
					compared_left_line.tag = Tag.equal;
					compared_left.add(compared_left_line);
					
					compared_right_line = new ComparedLine(notCompared_right.get(i).line);
					compared_right_line.tag = Tag.equal;
					compared_right.add(compared_right_line);	
					
					matching_line_count++;
					matching_left_index = j;
					matching_right_index = i;
					
					break;
				}
				
			}
		}
		
		
		
>>>>>>> e45d3bbc1a3274c6fb6ade56f3e6a5e22427220a
		
		for(int j = 1; j < left_size; j++){
			compared_left_line = new ComparedLine(notCompared_left.get(j-1).line);
			compared_left_line.tag = Tag.notequal;
			for(int i = 1; i < right_size; i++){
				compared_right_line = new ComparedLine(notCompared_right.get(i-1).line);
<<<<<<< HEAD
				if(table[i][j] == matching_line_count){
=======
				if(table[i][j] <= matching_line_count){
>>>>>>> e45d3bbc1a3274c6fb6ade56f3e6a5e22427220a
					compared_right_line.tag = Tag.notequal;
				}
				else{
					matching_line_count++;
					compared_right_line.tag = Tag.equal;
					compared_left_line.tag = Tag.equal;
					
					if(i > j){
						for(int count = 0; count < i - j; count++)
						compared_left.add(blank_line);
					}
					else if(i < j){
						for(int count = 0; count < i - j; count++){
						compared_right.add(blank_line);
						}
					}
					else{
						//null;
					}
				}
				compared_right.add(compared_right_line);
			}
			compared_left.add(compared_left_line);
		}		
	}
	
	public ArrayList<Line> getComparedLeft(){
		return compared_left;
	}
	
	public ArrayList<Line> getComparedRight(){
		return compared_right;
	}

}
