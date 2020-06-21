package com.coderealms.gitopsactions.propagateversion;

public class PropagationParams {

    private String opsRepo;
    private String opsRepoToken;
    private String targetEnvironment;
    private String version;
    private String versionFilePath;
    private Boolean autoApprovePullRequest;

    public String getOpsRepo() {
        return opsRepo;
    }

    public String getTargetEnvironment() {
        return targetEnvironment;
    }

    public PropagationParams setTargetEnvironment(String targetEnvironment) {
        this.targetEnvironment = targetEnvironment;
        return this;
    }

    public String getVersion() {
        return version;
    }

    public PropagationParams setVersion(String version) {
        this.version = version;
        return this;
    }

    public String getVersionFilePath() {
        return versionFilePath;
    }

    public PropagationParams setVersionFilePath(String versionFilePath) {
        this.versionFilePath = versionFilePath;
        return this;
    }

    public Boolean getAutoApprovePullRequest() {
        return autoApprovePullRequest;
    }

    public PropagationParams setAutoApprovePullRequest(Boolean autoApprovePullRequest) {
        this.autoApprovePullRequest = autoApprovePullRequest;
        return this;
    }

    public PropagationParams setOpsRepo(String opsRepo) {
        this.opsRepo = opsRepo;
        return this;
    }

    public String getOpsRepoToken() {
        return opsRepoToken;
    }

    public PropagationParams setOpsRepoToken(String opsRepoToken) {
        this.opsRepoToken = opsRepoToken;
        return this;
    }
}
