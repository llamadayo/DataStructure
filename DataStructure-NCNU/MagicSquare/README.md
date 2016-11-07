# 奇數魔術方陣  

![img](http://openhome.cc/Gossip/AlgorithmGossip/images/oddArray-2.jpg "from openhome.cc")  

## 特色 
> 為奇數NxN的奇數方陣  
> 每一行、每一列及對角線的和均相同  

## 解法
>將第一列的中央填入第一個數字  
>再繼續朝右上(左上)繼續填  
>若會遇到已有數字的格子則直接向下填

## 範例
>在20～30之間取一個奇數作為N  
>向右上開始進行排列
![Imgur](http://i.imgur.com/4SMoPrM.png)  

### 實做小撇步
>可以發現每一種方陣(3X3、5X5)中，會遇到已填有數字格子的數字之間有數列關係
