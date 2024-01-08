# 项目介绍
> 关于实战能力的提升的代码实例
> 内容:
> 1. 异步编程 Future的使用
> 2. 流式编程 Stream的使用
> 3. 应用打包部署快捷方式
> 4. Git 的使用
> 5. Docker插件使用 
> 6. JPA的学习案例

## 此内容将被cherry Pick到master分支上
cherry pick : 将别的分支中的提交或者代码,添加到当前分支
"此部分可以复制到master分支中" : 
    方法,右键选择项目-> GIT -> Compare With Branch -> 选择比较的分支 -> 选择你所需代码移动到你的版本 -> 本地再次提交


## 关于远端代码回退的问题
1. 本机回退 reset commitId 
   这里reset有4种选择, soft,mix,hard,keep 
   建议使用mix: 混合,将此提交后的提交的代码退出git管理区,但是本地不删除此提交后的代码 
   其中hard : 会将此提交后的提交的代码删除,本地删除 ,此方法可以强制恢复代码文件,当`git fsck`执行后出现文件丢失 
   注意单独reset 会将当前的提交推出git的工作区
2. 强制推送master分支到origin分支 :
   `git push -u origin master -f`,注意,加上-u和-f会覆盖远端代码,导致代码版本只能和本机一致
      
注意一些覆盖性命令: git fetch --all : 强制拉取远端代码覆盖本机代码