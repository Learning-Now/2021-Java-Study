
import org.apache.commons.lang3.ObjectUtils;
import org.kohsuke.github.*;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;


public class Github implements token{
    //personal token need to secret

    public static void main(String[] args) throws IOException {
        GitHub github = new GitHubBuilder().withOAuthToken(token.MY_PERSONAL_TOKEN).build();

        //Repository 연결
        GHRepository repo = github.getRepository("Learning-Now/2021-java-study");

        //IssueState ALL, OPEN, CLOSED
        List<GHIssue> issues = repo.getIssues(GHIssueState.ALL);
        Map<String, Integer> participant = new HashMap<>();
        for (GHIssue issue : issues) {

            Set<String> onlyOneParticipant = new HashSet<>();
            if (!issue.getLabels().isEmpty()) {
                for (GHIssueComment comment : issue.getComments()) {
                    if (!comment.getUser().getLogin().equals("Livenow14")) {
                        onlyOneParticipant.add(comment.getUser().getLogin());
                    }
                }
                for (String name : onlyOneParticipant) {
                    if(participant.containsKey(name)) {
                        participant.replace(name,participant.get(name)+1);
                        continue;
                    }
                    participant.put(name,1);
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        System.out.println(participant.size());
        //참여율 출력
        for(String name : participant.keySet()){
            double rate = (double)(participant.get(name) * 100) / participant.size();
            bw.write("name : " + name);
            bw.write(", Participation Rate : "+String.format("%.2f",rate)+"%");
            bw.newLine();
        }
        bw.close();


    }
}
