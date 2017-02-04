<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Force database installation</title>
    </head>
    <style>
        .error {
            color: red;
        }
        pre {
            color: green;
        }
    </style>
    <body>
        <h2>Database initialization in progress</h2>
        
        <%
            /* How to customize:
             * 1. Update the database name on dbname.
             * 2. Create the list of tables, under tablenames[].
             * 3. Create the list of table definition, under tables[].
             * 4. Create the data into the above table, under data[]. 
             * 
             * If there is any problem, it will exit at the very first error.
             */
            String mexico[] = {"During this experience we will get to know the history of National Mexican Drink, Tequila.",
                               "Agave plants thrive in Tequila, Mexico where conditions such as altitude and climate are perfect for its growth. Tequila is the national beverage of Mexico, and usually consumed for celebrations."
            };
            String athens[] = {"Greece offers tours & transfers in Athens, Greece. We visit Greece as travelers and view the historical sites from all angles.",
                                "Tracing the history and culture of Athens from ancient times to the present day and passing a plethora of various shopping opportunities that are along the route. You can easily visit the many things to do including World famous museums, with spectacular views of ancient temples, the Acropolis and Parthenon. Athens represents the juxtaposition of ancient history and modern life, which is a very rare experience and one not to be missed."
            };
            String london[] = {"Do some sightseeing around London on one of these top guided tours, from Buckingham Palace to the Tower of London and Warner Bros.",
                                "London is packed with plenty of things to do so let us guide you through the city to visit the prime locations and top attractions including historical museums, striking parks, and modern galleries. We invite you to experience all the magical sights and sounds of London in a comfortable and secure environment."
            };
            String rome[] = {"We invite you to experience all the magical sights and sounds of Rome with enthusiastic English speaking local guides.",
                                "From the Trevi fountain to the Colosseum, Rome’s abundant sights rival those of any other city on the planet, in terms of their beauty, historical importance and ability to simply take your breath away. Whether your interests lie in antiquity, architecture, cuisine, culture, religion, shopping or sport, Rome has something to suit all tastes."
            };
            String amsterdam[] = {"Amsterdam city bike tour. is a great way to discover Amsterdam. Join our eclectic, entertaining and exciting guided bike tour.",
                                "Capital of the Netherlands, Amsterdam is best known for its cultural delights, criss-crossing canal system and its laid back coffee shops with their famously liberal attitude. With over a million inhabitants, this Dutch gem is the country’s largest city and a financial, cultural and creative hub. Old and new effortlessly combine in this modern and liberal capital that is also home to some of the world most precious historic treasures."
            };
            String brussels[] = {"Antwerp and discover its culture, incredible places, stories and legends with entertaining and unforgettable local guides.",
                                "Brussels is home to the European Union with the European Parliament, Manneken Pis, Cinquantenaire Arch, Art Nouveau and Victor Horta, the Grand-Place and the Atomium. The city abounds in architectural monuments, from the Renaissance to modern times and discovering this heritage is full of surprises."
            };
            String lisbon[] = {"The best tours in Lisbon, Live Fado tours, typical food tours and the incredible Belém. Tours in Lisbon, a unique city in Europe.",
                                "Visit one of the oldest cities in the world. Lisbon history dates back to 300,000 years ago, however it emerged as a nation state in the early 12th century, and ranks as one of the world longest founded cities. From our start point of Marques do Pombal Square, for each of our 2 routes, you can discover and explore at your own leisure the city key sights, museums, gardens and attractions. Lisbon, a city of contrasts, offers so much to discover and surprise and still maintains the marks of its early history. It is heralded as one of the most beautiful capitals of Europe."
            };
            String prague[] = {"Discover Prague on an open top bus tour of this beautiful city. Explore Old town, the heart of Prague, with its well preserved 13th century houses.",
                                "Explore Old town, the heart of Prague, with its well preserved13th century houses and churches. Here, you’ll find the Old Town Hall, the Municipal House and the Estates Theatre. The Old Town Square is home to the famous Astronomical Clock which draws onlookers who gather to observe the skeleton ringing the bell and the other figurines which appear. When the bell chimes the hour, a trumpeter sounds a fanfare from the top of the tower. Hop off and see The Metronome monument, which is situated where the Stalin memorial statue once stood, and enjoy stunning views of the city."
            };
            

            String dbname = "demodb";
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            /* this will generate database if not exist */
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/" + dbname + ";create=true", "user", "pwd");
            Statement stmt = con.createStatement();
            
            try {
                stmt.execute("CREATE SCHEMA " + dbname);
                // schema was created; it will appear into: Other schemas -> "dbname"
            } catch (SQLException e) { 
                // schema already exists; do nothing.
             //out.println("<pre> -> ERROR <pre>");

            }
            
            /* drop tables if they exist */
            String tablenames[] = new String[] {
                "RESERVATIONS","TOURS","USERS",
            };
            for (String tablename : tablenames) {
                try { 
                    stmt.executeUpdate("DROP TABLE " + dbname + "." + tablename); 
                    out.println("<pre> -> DROP TABLE " + dbname + "." + tablename + "<pre>");
                } catch (SQLException e) { 
                    out.println("<pre> -> FIRST TIME <pre>");
                }
            }
            
            /* creating tables */
            
            /***                TABLES:
              
              USERS: nickname, password, name, lastName, email 
              TOURS: IDTour, title, shortDescription, longDescription, availablePlaces, price, destinationName, mounth
              
             ***/
            
            
            String tables[] = new String[] {
            /** CREATE ALL THE TABLES **/
                "CREATE TABLE " + dbname + ".USERS (nickname VARCHAR(20) PRIMARY KEY NOT NULL, password VARCHAR(15) NOT NULL, name VARCHAR(25) NOT NULL, lastName VARCHAR(25) NOT NULL, email VARCHAR(30) NOT NULL)",
                "CREATE TABLE " + dbname + ".TOURS (IDTour INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), title VARCHAR(50) NOT NULL, shortDescription VARCHAR(1000) NOT NULL, longDescription VARCHAR(1000) NOT NULL, availablePlaces INT NOT NULL, price FLOAT NOT NULL,destinationName VARCHAR(20) NOT NULL, mounth VARCHAR(15) NOT NULL)",
                "CREATE TABLE " + dbname + ".RESERVATIONS (IDReservation INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), IDUser VARCHAR(20), IDTour INT NOT NULL, totalPrice FLOAT NOT NULL, quantity INT NOT NULL)",
             /** FOREIGN KEYS **/
                "ALTER TABLE " + dbname + ".RESERVATIONS ADD CONSTRAINT FK_user FOREIGN KEY (IDUser) REFERENCES " + dbname + ".USERS (nickname) ON DELETE CASCADE",
                "ALTER TABLE " + dbname + ".RESERVATIONS ADD CONSTRAINT FK_tour FOREIGN KEY (IDTour) REFERENCES " + dbname + ".TOURS (IDTour) ON DELETE CASCADE",
            
            };
            
            for (String table : tables) {
                try {
                    stmt.execute(table);
                } catch(SQLException e) {
                    out.println("<span class='error'>Error creating table: " + table + "</span>");
                    return;
                }
                out.println("<pre> -> " + table + "<pre>");
            }
            
            /* inserting data */
            /* you have to exclude the id autogenerated from the list of columns if you have use it. */
            
            /***  INSERT DATA TO DB
             * USER1= juank, tutu123, Juan Carlos, Anguiano, jkanguaino@udg.com
             * USER2= lalo, lala098, Eduardo, Gutiérrez, egutierrez@univa.com
             * USER3= sobr, sobr, Open, Systems, sobr@urv.cat
            ****/
            
            String data[] = new String[]{
                /*INSERT TABLE USERS*/
                "INSERT INTO " + dbname + ".USERS(nickname, password, name, lastName, email) "
                    /** USER1 **/
                   + "VALUES ('juank','tutu123','Juan Carlos','Anguiano','jkanguaino@udg.com'),"
                    /** sobr **/
                   + "('sobr','sobr','Open','Systems','sobr@urv.cat'),"
                    /** USER2 **/
                   + "('lalo','lala098','Eduardo','Gutiérrez','egutierrez@univa.com')",
                    
                    /*INSERT TABLE TOURS*/
                "INSERT INTO " + dbname + ".TOURS(title,shortDescription,longDescription,availablePlaces,price,destinationName,mounth)"
                    /** MEXICO **/
                    + " VALUES ('Tequila Tour Mexico','"+mexico[0]+"','"+mexico[1]+"',11,999.99,'mexico','January'), "                   
                    /** ATHENS **/
                    + " ('ATHENS','"+athens[0]+"','"+athens[1]+"',7,550.10,'athens','February'),"  
                    /** LONDON **/
                    + " ('LONDON','"+london[0]+"','"+london[1]+"',17,600.00,'london','March'),"
                    /** ROME **/
                    + " ('ROME','"+rome[0]+"','"+rome[1]+"',1,100.00,'rome','April'),"
                    /** AMSTERDAM **/
                    + " ('AMSTERDAM','"+amsterdam[0]+"','"+amsterdam[1]+"',7,400.00,'amsterdam','May'),"
                    /** BRUSSELS **/
                    + " ('BRUSSELS','"+brussels[0]+"','"+brussels[1]+"',9,450.00,'brussels','June'),"                    
                    /** LISBON **/
                    + " ('LISBON','"+lisbon[0]+"','"+lisbon[1]+"',5,249.00,'lisbon','July'),"   
                    /** PRAGUE **/
                    + " ('PRAGUE','"+prague[0]+"','"+prague[1]+"',4,700.00,'prague','August')",
                    
                    /*INSERT TABLE RESERVATIONS*/
                "INSERT INTO " + dbname + ".RESERVATIONS(IDUser,IDTour,totalPrice,quantity) VALUES ('juank',7,249,1)"
                    

            };
            
            for (String datum : data) {
                if (stmt.executeUpdate(datum)<=0) {
                    out.println("<span class='error'>Error inserting data: " + datum + "</span>");
                    return;
                }
                out.println("<pre> -> " + datum + "<pre>");
            }
            
        %>
        <button onclick="window.location='<%=request.getSession().getServletContext().getContextPath()%>'">Go home</button>
    </body>
</html>
