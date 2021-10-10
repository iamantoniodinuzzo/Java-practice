public class Answer {
    private String answer;
    private int vote;

    public Answer(Question question, String answer){
        this.answer = answer;
        this.vote = 0;
        question.addAnswer(this);
    }

    public void voteUp(){
        this.vote++;
    }

    public int getVote() {
        return vote;
    }

    @Override
    public String toString() {
        return answer;
    }
}
