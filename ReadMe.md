#NAV Calculation of thousands of Stock Portfolios

##Objective:
To create 10,000 Portfolios, each aving 25 stock symbols and their quantities, and to calculate the Net Asset Value(NAV) of each portfolio by streaming the live closing prices of the symbols.

#How to run the Project:
<ul>
<li>First step is to download the "companylist.csv" file, as it conatins the stock symbols.
<li>Then, the next step is to run <strong>PortfolioGenerator.java</strong> present in the PortfolioGenerator folder. This generates 10,000 portfolios.<br>
(Note: Also change the path of the companylist.csv and output portfolios, since the path given in the code is for my system.)
<li>Now, after generation of 10,000 portfolios, we have to stream for live closing prices for the symbols, so here we run the file <strong>EODStockStreamer.java</strong> from the EODStockStreamer folder. This will create a .csv file containing the closing prices of all the symbols from companylist.csv of that day.<br>
(Note: Paths given in the code are to be changed accordingly.)
<li>The last part is to Map/Reduce the data and calculate the Net Asset Value of all the individual portfolios. Here we run the file <strong>PortDriver.java</strong> that is in PortfolioMR folder, which will give us the output in a folder called "FinalValuation".<br>
(Note: Paths given in the code are to be changed accordingly.)
</ul>

#Refernce
EODStockstreamer uses a library written by [**natehefner**](https://github.com/natehefner/yahoostocks-java).