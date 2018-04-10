package com.deity.github.data.net.api.base;

import android.support.annotation.IntDef;

/**
 * 接口定义
 * Created by deity on 18-4-10.
 */

public interface RepoApi {

    public int REPO_ANDROID = 0;
    public int REPO_JAVA = 1;
    public int REPO_PYTHON = 2;
    public int REPO_SHELL = 3;

    @IntDef({REPO_ANDROID,REPO_JAVA,REPO_PYTHON,REPO_SHELL})
    public @interface RepoType{}


}
