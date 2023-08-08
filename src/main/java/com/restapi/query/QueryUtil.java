package com.restapi.query;

public class QueryUtil {
    private static String fields = "select b.book_id,b.book_title,b.author_id,a.first_name,a.last_name,a.language";
    private static String join = fields+ " from books b left outer join authors a on b.author_id=a.id";
    public String rangeQuery(int start,int end){
        return "select * from books where book_id between "+ start+ " and " +end;
    }
}
