Stock Market App – Design Patterns
Singleton

Used in: ListOfStocks, MarketClock
Why: Ensures a single, globally accessible instance of the market inventory and trading clock.

Factory

Used in: AssetsFactory, CreateStock, CreateCrypto
Why: Encapsulates the creation of different asset types (Stock, Crypto) without exposing concrete classes.

State

Used in: MarketState, StockMarketOpenState, CryptoMarketState
Why: Controls whether an asset can be traded based on market conditions (e.g. stock market hours).

Strategy

Used in: TradingStrategy, TradingTemplate, DayTradingStrategy, LongTermStrategy, ThresholdStrategy, User
Why: Allows dynamic switching between different trading behaviors without modifying client code.

Template Method

Used in: TradingTemplate
Why: Defines the fixed workflow for buy/sell operations while allowing strategies to customize specific steps.

Command

Used in: CommandHandler
Why: Encapsulates buy and sell actions as commands, decoupling user input from execution logic.

Facade

Used in: TradingFacade
Why: Provides a simplified interface for trading operations, hiding system complexity from clients.

Mediator

Used in: MarketMediator, ConcreteMarketMediator
Why: Centralizes communication between users and the market, reducing direct dependencies.

Observer

Used in: ObservableAsset, Observer, User
Why: Notifies users when watched assets change price.

Decorator (Conceptual / Lightweight)

Used in: Holding
Why: Wraps an Asset with additional data (quantity, future extensions) without modifying the original class.
