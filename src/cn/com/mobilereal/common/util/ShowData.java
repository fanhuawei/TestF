package cn.com.mobilereal.common.util;
/**
 * <p>ClassName: ShowData</p>
 * <p>Description: TODO</p>
 * <p>Author: linyc</p>
 * <p>Date: 2014-7-21</p>
 */
public class ShowData {
    /**
     * <p>Description: excel值</p>
     */
    private String value;
    /**
     * <p>Description: 错误描述</p>
     */
    private String errorMessage;
    /**
     * <p>Description: excel是否正确标识</p>
     */
    private String isRight;
    /**
     * <p>Description: excel行</p>
     */
    private int row;
    /**
     * <p>Description: excel列</p>
     */
    private String cell ; 
    /**
     * <p>Description: 构造方法</p>
     */
    public ShowData() {

    }
    /**
     * <p>Description: 构造方法</p>
     * @param value excel的值
     */
    public ShowData(String value) {
        this.value = value;
    }
    /**
     * <p>Description: 构造方法</p>
     * @param value excel的值
     * @param isRight 是否正确标识
     */
    public ShowData(String value, String isRight) {
        this.value = value;
        this.isRight = isRight;
    }
    /**
     * <p>Description: 构造方法</p>
     * @param value excel的值
     * @param isRight 是否正确标识
     * @param errorMessage 错误描述
     */
    public ShowData(String value, String isRight, String errorMessage) {
        this.value = value;
        this.isRight = isRight;
        this.errorMessage = errorMessage;
    }
    /**
     * <p>Description: 构造方法</p>
     * @param value excel的值
     * @param isRight 是否正确标识
     * @param errorMessage 错误描述
     * @param row excel行
     */
    public ShowData(String value, String isRight, String errorMessage, int row) {
        this.value = value;
        this.isRight = isRight;
        this.errorMessage = errorMessage;
        this.row = row ;
    }
    /**
     * <p>Description: 构造方法</p>
     * @param value excel的值
     * @param isRight 是否正确标识
     * @param errorMessage 错误描述
     * @param row excel行
     * @param cell  excel列
     */
    public ShowData(String value, String isRight, String errorMessage, int row, String cell) {
        this.value = value;
        this.isRight = isRight;
        this.errorMessage = errorMessage;
        this.row = row ;
        this.cell = cell;
    }
    

    public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }
    
    public String getCell() {
        return cell;
    }
    public void setCell(String cell) {
        this.cell = cell;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public String getErrorMessage() {
        return errorMessage;
    }
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    public String getIsRight() {
        return isRight;
    }
    public void setIsRight(String isRight) {
        this.isRight = isRight;
    }
	
}
