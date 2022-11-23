package pj1.dto;

import lombok.Data;

@Data
public class QnaDto {
	private int qnaIdx;
	private String memEmail;
	private String itemNum;
	private String qnaTitle;
	private String qnaContents;
	private String qnaWriteDate;
	private int qnaHit;
	private String qnaCommentContent;
	private String qnaCommentWriteDate;
	private String qnaAns;
}
