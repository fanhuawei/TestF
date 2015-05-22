/**
 * QuestionBean.java
 * Created at 2014-07-22
 * Created by Fanhuawei
 * Copyright (C) 2014 SHANGHAI VOLKSWAGEN, All rights reserved.
 */

package cn.com.mobilereal.common.bean;
import java.io.Serializable;
/**
 * <p>ClassName: QuestionBean</p>
 * <p>Description: 构建题库问题对象</p>
 * <p>Author: Fanhuawei</p>
 * <p>Date: 2014年7月22日</p>
 */
@SuppressWarnings("serial")
public class QuestionBean implements Serializable {
    /**
     * <p>Description: 一级序号</p>
     */
    private String codeOne;
    
    /**
     * <p>Description: 一级名称</p>
     */
    private String contentOne;
    
    /**
     * <p>Description: 二级序号</p>
     */
    private String codeTwo;
    
    /**
     * <p>Description: 二级名称</p>
     */
    private String contentTwo;
    
    /**
     * <p>Description: 三级序号</p>
     */
    private String codeThree;
    
    /**
     * <p>Description: 三级名称</p>
     */
    private String contentThree;
    
    /**
     * <p>Description: 四级序号</p>
     */
    private String codeFour;
    
    /**
     * <p>Description: 四级名称</p>
     */
    private String contentFour;
    
    /**
     * <p>Description: 关键字</p>
     */
    private String keyword; 

    public String getCodeOne() {
        return codeOne;
    }

    public void setCodeOne(String codeOne) {
        this.codeOne = codeOne;
    }

    public String getContentOne() {
        return contentOne;
    }

    public void setContentOne(String contentOne) {
        this.contentOne = contentOne;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getCodeTwo() {
        return codeTwo;
    }

    public void setCodeTwo(String codeTwo) {
        this.codeTwo = codeTwo;
    }

    public String getContentTwo() {
        return contentTwo;
    }

    public void setContentTwo(String contentTwo) {
        this.contentTwo = contentTwo;
    }

    public String getCodeThree() {
        return codeThree;
    }

    public void setCodeThree(String codeThree) {
        this.codeThree = codeThree;
    }

    public String getContentThree() {
        return contentThree;
    }

    public void setContentThree(String contentThree) {
        this.contentThree = contentThree;
    }

    public String getCodeFour() {
        return codeFour;
    }

    public void setCodeFour(String codeFour) {
        this.codeFour = codeFour;
    }

    public String getContentFour() {
        return contentFour;
    }

    public void setContentFour(String contentFour) {
        this.contentFour = contentFour;
    }
    
    
    
    
    
}
