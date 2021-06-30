PROCEDURE getValuesHeSoByKhhs(
p_KHHSs VARCHAR2,
p_KY_TINH_LUONG NUMBER,
p_CBCC_ID NUMBER,
v_cursor OUT ref_cursor
) AS
 outputString VARCHAR2(999);temp VARCHAR2(100); value VARCHAR(100);myQuery VARCHAR2(1000);
BEGIN
         outputString := '';
    FOR RowItem IN (SELECT * FROM SPLIT(p_KHHSs))
            LOOP
                myQuery:= '';
    SELECT (SELECT map.TEN_COT_TU1
            FROM TBS_SYS_MAP_TBL map
            WHERE map.DIEU_KIEN2 = RowItem.COLUMN_VALUE AND map.TEN_BANG = 'TBD_LU_THLT_CT' FETCH FIRST 1 ROWS ONLY)
    INTO temp FROM DUAL;
    myQuery := 'SELECT
                thltCt.' || temp||
                ' FROM TBD_LU_THLT_CT thltCt
                INNER JOIN TBD_LU_THLT thlt ON thlt.ID = thltCt.THLT_ID
                WHERE thlt.KY_TINH_LUONG = ' || p_KY_TINH_LUONG || ' AND thlt.TH_LHS1 =''X''
                AND thltCt.CBCC_ID = ' || p_CBCC_ID ;
    EXECUTE IMMEDIATE
        myQuery INTO value;
    outputString := outputString || '-' || value;
    END LOOP;
    OPEN v_cursor FOR
    SELECT outputString AS "VALUES" FROM dual;
END;