import java.util.ArrayList;

public class Question {
    private String question;
    private ArrayList<Answer> answers ;

    public Question(String question){
        this.question = question;
        answers = new ArrayList<>();
    }

    public Answer getBestAnswer(){
        Answer best = null;
        for (Answer answer : answers) {
            if(best == null){
                best = answer;
            }else if(answer.getVote() > best.getVote())
                best = answer;
        }
        return best;

    }
    public void addAnswer(Answer answer){answers.add(answer);}
    
    public static void main(String[] args) {
        Question q = new Question("Dove si trova Albuquerque?");
        Answer a1 = new Answer(q, "Canada");
        Answer a2 = new Answer(q, "New Mexico");
        a1.voteUp();
        System.out.println(q.getBestAnswer());
        a2.voteUp();
        a2.voteUp();
        System.out.println(q.getBestAnswer());
    }
}
