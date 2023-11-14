package com.markuvweb.unitmover.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UnitLogDTO {

    private long snoId;
    private String sno;
    private String pdLine;
    private String wc;
    private int isPass;
    private String inputType;
    private String editor;
    private String cdt;
    private String udt;
    private long id;

    public void setUnitDTO(long snoId, String sno, String pdLine, String wc, int isPass, String inputType, String editor, String cdt, String udt){
        setSnoId(snoId);
        setSno(sno);
        setPdLine(pdLine);
        setWc(wc);
        setIsPass(isPass);
        setInputType(inputType);
        setEditor(editor);
        setCdt(cdt);
        setUdt(udt);
    }
}