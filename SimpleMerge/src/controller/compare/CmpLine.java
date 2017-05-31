package controller.compare;

import java.util.ArrayList;

public interface CmpLine {

	//transform Paragraph data to structured ArrayList data
	//return ArrayList<Paragraph>
	public ArrayList<Line> constructLine(Paragraph notCompared_PG);
	
	/*each line in paragraph is moved to match the position of lines
	 * and have tag option that used to highlight text color*/
	//please check the Editable option value
	public void matchEqualLine(ArrayList<Line> notCompared_PG_contents);
}
