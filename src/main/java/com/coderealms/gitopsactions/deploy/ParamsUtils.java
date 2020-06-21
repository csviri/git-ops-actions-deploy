package com.coderealms.gitopsactions.deploy;

public class ParamsUtils {

    public static PropagationParams toPropagationParams(String[] args) {
        PropagationParams propagationParams = new PropagationParams();
        for (String arg : args) {
            int delimiterIndex = arg.indexOf("=");
            String key = arg.substring(0, delimiterIndex);
            String value = arg.substring(delimiterIndex + 1);
            switch (key) {
                case "ops-repo":
                    propagationParams.setOpsRepo(value);
                    break;
                case "ops-repo-token":
                    propagationParams.setOpsRepoToken(value);
                    break;
                case "target-environment":
                    propagationParams.setTargetEnvironment(value);
                    break;
                case "version":
                    propagationParams.setVersion(value);
                    break;
                case "version-file-path":
                    propagationParams.setVersionFilePath(value);
                    break;
                case "auto-approve-pr":
                    propagationParams.setAutoApprovePullRequest(Boolean.valueOf(value));
                    break;
                default:
                    throw new IllegalArgumentException("Unknows param key:" + key);
            }
        }
        return propagationParams;
    }

}
