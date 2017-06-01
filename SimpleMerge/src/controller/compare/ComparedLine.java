package controller.compare;

public class ComparedLine extends Line{
	
	ComparedLine(String str){
		this.line = str;
	}
	
	/*
	 * Tag :
	 * { space : showing gray line }
	 * { equal : showing white line }
	 * { notequal : showing yellow line }
	 */
	enum Tag{
		space, equal, notequal
	}
	
	Tag tag;
	
}