create FUNCTION             "SPLIT" (
    p_string      IN   VARCHAR2,
    p_delimiter   IN   VARCHAR2 := ','
) RETURN T_ARRAY
    PIPELINED
    PARALLEL_ENABLE
AS
    l_string        LONG := p_string || p_delimiter;
l_comma_index   PLS_INTEGER;
    l_index         PLS_INTEGER := 1;
    p_temp          VARCHAR2(32767);
BEGIN
    LOOP
l_comma_index := instr(l_string, p_delimiter, l_index);
        EXIT WHEN l_comma_index = 0;
        p_temp := trim(substr(l_string, l_index, l_comma_index - l_index));
        IF ( p_temp IS NOT NULL ) THEN
            PIPE ROW ( p_temp );
END IF;
        l_index := l_comma_index + 1;
END LOOP;
    return;
END split;
/

(create type T_ARRAY as table of VARCHAR2(100)
/)