package com.coderealms.gitopsactions.deploy;

import org.kohsuke.github.GHPullRequest;
import org.kohsuke.github.GHRef;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class PropagationService {

    public void propagateVersion(PropagationParams propagationParams) {
        GitHubService gitHubService = new GitHubService(propagationParams.getOpsRepoToken(), propagationParams.getOpsRepo());
        try {
            String newBranch = "version-update-" + propagationParams.getVersion();
            GHRef ref = gitHubService.createBranch(newBranch, propagationParams.getTargetEnvironment());
            gitHubService.propagateVersionFile(propagationParams.getVersionFilePath(), propagationParams.getVersion(), newBranch);
            GHPullRequest pr = gitHubService.createPullRequest(newBranch, propagationParams.getTargetEnvironment(),propagationParams.getVersion());
            if (propagationParams.getAutoApprovePullRequest()) {
                pr.merge("Merge PR for version " + propagationParams.getVersion());
                ref.delete();
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }

    }

}
