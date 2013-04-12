package dojo.model;

public class Question {
    private Long id;
    public String question = "";
    public String answer = "";

    public Question() {}

    public Question(Long id, String question, String answer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
    }

    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }



    public Long getId() {
        return id;
    }

}