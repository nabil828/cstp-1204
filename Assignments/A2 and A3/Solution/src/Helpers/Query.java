package Helpers;

public class Query {
    public QueryTypeEnum type;
    public String userA;
    public String userB;
    public Query(QueryTypeEnum type, String userA, String userB) {
        super();
        this.type = type;
        this.userA = userA;
        this.userB = userB;
    }
}
