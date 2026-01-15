Stock Market App - Design Patterns
1. Singleton

Used in: ListOfStocks, MarketClock

Why: Ensures a single, globally accessible instance of market inventory and clock throughout the app.

2. Factory

Used in: AssetsFactory (abstract), CreateStock, CreateCrypto

Why: Encapsulates the creation of different asset types (Stock, Crypto) without exposing constructors directly.

3. State

Used in: MarketState, StockMarketOpenState, CryptoMarketState

Why: Encapsulates trading rules based on market state, e.g., stocks can only be traded during market hours.

4. Strategy

Used in: TradingStrategy interface, DayTradingStrategy, LongTermStrategy, ThresholdStrategy, User class

Why: Allows users to switch between different trading behaviors dynamically without changing core logic.

5. Command

Used in: CommandHandler

Why: Encapsulates buy/sell operations as commands, allowing the user to execute trades without directly interacting with portfolio or market internals.
