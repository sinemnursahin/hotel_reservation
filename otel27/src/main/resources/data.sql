CREATE TABLE IF NOT EXISTS room (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      name VARCHAR(255),
                      price DECIMAL(10, 2),
                      available BOOLEAN,
                      SIZE DECIMAL(2,0),
                      ROOM_PICTURE_NAME VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS room_property (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      property VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS ROOM_ROOM_PROPERTIES (
                      room_id BIGINT AUTO_INCREMENT,
                      room_properties_id BIGINT AUTO_INCREMENT
);

CREATE TABLE IF NOT EXISTS hotel_user (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(255),
                        email VARCHAR(255),
                        password VARCHAR(255),
                        user_role VARCHAR(255)
                        );

INSERT INTO room (name, price, available, room_picture_name, SIZE) VALUES
                                                                 ('Tropik Oda', 3000.00, true, 'tropik.jpg', 4),
                                                                 ('Gökyüzü Odası', 1500.00, true, 'gokyuzu.jpg', 3),
                                                                 ('Overthink Odası', 1200.00, true, 'overthink.jpg', 2),
                                                                 ('Akvaryum Odası', 3800.00, true, 'akvaryum.jpg', 5),
                                                                 ('Vintage Odası', 3500.00, true, 'vintage.jpg', 4);

insert into room_property(property) VALUES
                                            ('Egzotik Dekorasyon: Tropik bitkiler, bambu mobilyalar, deniz kabukları ve sıcak renklerle tasarlanmış bir iç mekan.'),
                                            ('Hamak veya Salıncak: Rahatlama alanı olarak bir hamak veya tavan salıncağı kurulabilir.'),
                                            ('Manzara Temalı Duvar Kağıdı: Duvarlarda palmiye ağaçları, beyaz kumlu plajlar ve turkuaz denizi gösteren duvar kağıtları.'),
                                            ('Aromatik Koku ve Aydınlatma: Hindistan cevizi, vanilya veya tropik meyve kokuları ve loş bir ambiyans için LED aydınlatmalar.'),
                                            ('Spa Deneyimi: Jakuzili bir banyo, doğal taşlarla döşenmiş bir duş veya açık hava hissi veren bir küvet.'),
                                            ('Tropik Detaylar: Hasır şapka, tiki bar köşesi veya tropik desenli yatak örtüleri gibi tematik aksesuarlar.'),
                                            ('Panoramik Cam Tavan: Odayı tamamen cam bir tavanla donatarak gerçek gökyüzünü izleme imkanı sağlayabilirsiniz. Gece yıldızlar, gündüz bulutlar eşlik eder.'),
                                            ('Yıldız Projektörleri: Bulutlu günlerde veya geceyi daha da büyüleyici hale getirmek için yıldız projektörleriyle suni bir gökyüzü efekti ekleyin.'),
                                            ('Dinlendirici Sesler: Hafif rüzgar sesi, kuş cıvıltıları veya hafif gök gürültüsü gibi doğa sesleri sunan bir ses sistemi.'),
                                            ('Rahatlama Alanı: Puf koltuklar veya bulut temalı minderlerle, uçuyormuş gibi hissettiren bir oturma köşesi.'),
                                            ('Gökyüzü Aksesuarları: Bulut şeklinde avizeler, uçan balon figürleri veya güneş ve ay temalı detaylar.'),
                                            ('Doğal Malzemeler: Odaya sıcaklık katmak için ahşap ve doğal taş gibi organik malzemeler kullanabilirsiniz. Bu, cam tavanla uyumlu bir atmosfer yaratır.'),
                                            ('Boydan Boya Kitaplık: Duvarlar, tavana kadar uzanan ahşap kitaplıklarla kaplı, yüzlerce kitabı düzenli bir şekilde sergileyen bir kütüphane hissi veriyor.'),
                                            ('Okuma Köşesi: Yumuşacık bir şezlong, puf minderler ve battaniyelerle donatılmış, huzurlu bir okuma alanı yer alıyor.'),
                                            ('Ayarlanabilir Aydınlatma: Gece okuma için kitap dostu LED ışıklar ve vintage masa lambaları, göz yormayan bir ışık sağlıyor.'),
                                            ('Doğal Dokular: Ahşap mobilyalar, kitap temalı halılar ve minimalist dekorasyon ile doğal ve sıcak bir atmosfer yaratılmış.'),
                                            ('Hafif Ses Sistemi: Doğadan gelen hafif yağmur sesi veya rüzgar uğultusu, odada huzur dolu bir okuma deneyimi sunuyor.'),
                                            ('Rahat Çalışma Masası: Ahşap bir çalışma masası, ergonomik bir sandalye ve masa lambası ile donatılmış, okuma ve yazma için mükemmel bir alan sağlıyor.'),
                                            ('Cam Tavan ve Duvarlar: Deniz yaşamını izlemek için tam panoramik bir görüş sunan cam tavan ve duvarlar.'),
                                            ('Doğal Deniz Manzarası: Akvaryumun içindeki canlı balıklar, mercanlar ve diğer deniz canlıları ile çevrili ortam.'),
                                            ('Ambiyans Aydınlatma: Renk değiştiren LED ışıklarla su altı atmosferini tamamlayan yumuşak aydınlatma.'),
                                            ('Lüks Yatak Alanı: Deniz manzarasına bakan konforlu bir kral boy yatak.'),
                                            ('Su Altı Ses Sistemleri: Deniz altı efektlerini hissettiren entegre ses sistemi.'),
                                            ('Özel Jakuzi veya Küvet: Deniz manzarasına karşı rahatlama sağlayan bir jakuzi.'),
                                            ('Eski Tip Aydınlatma: Kristal avizeler, sarkıt lambalar veya eski tarz masa lambaları, vintage bir ambiyans yaratacak şekilde odanın her köşesine yerleştirilmiş.'),
                                            ('Klasik Halılar ve Kilimler: El dokuması eski halılar veya vintage tarzda desenli kilimler, odanın zeminine nostaljik bir dokunuş katıyor.'),
                                            ('Eski Metal Çerçeveli Yatak: Metal bir yatak çerçevesi, vintage tarzını destekleyen, romantik ve klasik bir detay oluşturuyor.'),
                                            ('Vintage Duvar Lambaları: Eski tarz duvar lambaları, odanın farklı köşelerine nostaljik bir ışıltı katıyor.'),
                                            ('Vintage Küçük Raflar ve Sepetler: Eski tarz raflar veya sepetler, kitap, aksesuar veya dekoratif objeler için harika depolama alanları sağlar.'),
                                            ('Eski Moda Portreler ve Tablo Çerçeveleri: Eski portreler veya klasik tablolar, antik tarzda çerçeveler içinde odanın duvarlarında yer alarak nostaljik bir şıklık yaratıyor.');



insert into room_room_properties(room_id, room_properties_id) values
                                     (1, 1),
                                     (1, 2),
                                     (1, 3),
                                     (1, 4),
                                     (1, 5),
                                     (1, 6),
                                     (2, 7),
                                     (2, 8),
                                     (2, 9),
                                     (2, 10),
                                     (2, 11),
                                     (2, 12),
                                     (3, 13),
                                     (3, 14),
                                     (3, 15),
                                     (3, 16),
                                     (3, 17),
                                     (3, 18),
                                     (4, 19),
                                     (4, 20),
                                     (4, 21),
                                     (4, 22),
                                     (4, 23),
                                     (4, 24),
                                     (5, 25),
                                     (5, 26),
                                     (5, 27),
                                     (5, 28),
                                     (5, 29),
                                     (5, 30);


-- hotel_user tablosuna örnek kullanıcı ekleme
INSERT INTO hotel_user (name, email, password, user_role) VALUES
                                                   ('nisasilaaltun', 'nisasilaaltun@test.com', '1234', 'CLIENT'),
                                                   ('test', 'test@test.com', '1234', 'ADMIN');