package bahti.gui;
import java.util.ArrayList;
public class Questions
{
    public String ques;
    public String[] ans;
    public int answer;
    public Questions(){
        this.ques= "";
        this.ans = new String[4];
    }
    public Questions(String ques, String[] ans, int answer)
    {
        this.ques=ques;
        this.ans= ans;
        this.answer = answer;
    }
    public String getQuestion()
    {
        return ques;
    }
    public String getAnswer(int pos)
    {
        String output=ans[pos];
        return output;
    }
    @Override
    public String toString()
    {
        String output="a. "+getAnswer(0)+"\nb. "+getAnswer(1)+"\nc. "+getAnswer(2)+"\nd. "+getAnswer(3);
        return "Q: "+ques+"\n"+output;
    }
}