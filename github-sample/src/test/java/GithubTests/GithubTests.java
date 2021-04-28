package GithubTests;

import com.google.common.collect.ImmutableBiMap;
import com.jcabi.github.*;
import org.testng.annotations.Test;

import java.io.IOException;

public class GithubTests {

    @Test
    public void testCommits() throws IOException {
        Github github = new RtGithub("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");
        RepoCommits commits = github.repos().get(new Coordinates.Simple("danteaut2", "Quest1")).commits();
        for (RepoCommit commit : commits.iterate(new ImmutableBiMap.Builder<String, String>().build())) {
            System.out.println(new RepoCommit.Smart(commit).message());
        }
    }
}