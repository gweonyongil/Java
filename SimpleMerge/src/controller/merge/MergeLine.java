package controller.merge;

public interface MergeLine {

	//copy line from Destination  to Source PG
	public void moveLineTo(Paragraph Des_compared_PG, Paragraph Src_compared_PG, int line_num);
}
