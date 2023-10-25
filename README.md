# Graph_6
Bu projede Havel Hakimi Algoritması kullanıldı. Kullanıcıdan bir grafın derece dizileri alınarak graf belirtip belirtmediği ekrana yazıldı. Ve graf belirtiyorsa da grafı çizildi. 


ÖZEL NOT: Prof. Dr. Tufan hocam daha öncesinde "https://github.com/lim-anggun/dfs-bfs-havelhakimi" daki projenin arayüzünü kullanmıştım, kodları yine bana aitti ancak bir kaç grafı doğru hesaplayamadığı için bir ayar çekmek istedim ama projedeki UI ı kullanmayı becermediğim için (daha doğrusu UI alışık olmadığım için kod yazarken hallaç pamuğuna döndü ) arayüzü biraz vasat olsa da kendi yaptığım bu arayüze taşındım. 

Yeni arayüzüm

![alt text](https://github.com/Kulac12/Graph_6/blob/master/Graph_foto/ilk%20aray%C3%BCz.PNG)

("https://github.com/lim-anggun/dfs-bfs-havelhakimi" dan aldığım eski arayüz) ve 2,2,2,2 vb. dizileri hatalı çiziyordu. 
![alt text](https://github.com/Kulac12/Graph_6/blob/master/Graph_foto/hh_i.PNG)

Sorunun neyden kaynaklandığını anlamak için önce matrisi doğru oluşturup oluşturmadığına baktım. Ve matrisi hatalı oluşturduğunu gördüm.
![alt text](https://github.com/Kulac12/Graph_6/blob/master/Graph_foto/hh_iii.PNG)

Ardından çözüm olarak tüm elemanlar '2' ise çevre grafı oluşturması için bi koşul eklendi. Sonuç başarılı.
![alt text](https://github.com/Kulac12/Graph_6/blob/master/Graph_foto/hh_cozim.PNG)
![alt text](https://github.com/Kulac12/Graph_6/blob/master/Graph_foto/hh_cozim2.PNG)

Havel Hakimi "graf belirtmeyen bazı örnekler"
![alt text](https://github.com/Kulac12/Graph_6/blob/master/Graph_foto/hh_cozim3.PNG)


Bazı Örnek Çıktılar

![alt text](https://github.com/Kulac12/Graph_6/blob/master/Graph_foto/hh_s1.PNG)
![alt text](https://github.com/Kulac12/Graph_6/blob/master/Graph_foto/hh_s.PNG)
![alt text](https://github.com/Kulac12/Graph_6/blob/master/Graph_foto/hh_iiii.PNG)

