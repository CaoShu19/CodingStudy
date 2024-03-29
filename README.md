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
2. 强制推送master分支到远程的origin仓库中 :
   `git push -u origin master -f`,注意,加上-u和-f会覆盖远端代码,导致代码版本只能和本机一致
```
   "因为已经推送代码到远端后,本地进行reset,会导致本地最新提交落后于远端对应分支"
   "git 会建议你先pull 下来将远端的代码也同步下来,然后修改提交"
   "很明显,你不需要错误提交并且推送的代码,此时可以用强制推送"
```

注意一些覆盖性命令: git fetch --all : 强制拉取远端代码覆盖本机代码

说一下推送拒绝的情况[这里会出现第二种情况]:
1. 你的head和远端head不同
2. 你本地代码修改了,但远端代码没修改,同时使用了amend来补充提交
公共分支的情况:
1. 先 pull --rebase 或者 fetch --all将代码拉下来
2. 再解决冲突[选择你需要的代码] 合并代码,之后对分支右键push
3. 然后会弹出拒绝推送, 选择merge选项即可
个人建议:amend就不要修改原来代码,只是增加代码即可,若是修改原来代码,直接创建一个新commit,就基本不会出现拒绝
也就是说,只有merge|回滚提交时需要解决拒绝推送问题,其余不用担心

