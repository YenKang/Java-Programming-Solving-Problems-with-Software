1.確認stringa是否有在stringb裡面

2.沒有的話，結束，回報次數

>3.有的話，把當前currIndex 到值存起來，並且計算有此string1次

4.接著，把剛剛currIndex ＋stringa.length() 作為 下一個currIndex

5.從 String.indexOf(stringa,currIndex)找尋currIndex

6.判斷currenIndex是不是 -1，是個話，返回count

>7.不是的話，把當前currIndex 到值存起來，並且計算有此string1次

8.接著，把剛剛currIndex ＋stringa.length() 作為 下一個currIndex

9.從 String.indexOf(stringa,currIndex)找尋currIndex

10.6.判斷currenIndex是不是 -1，是個話，返回count
