-- --------------------------------------------------------

--
-- Table structure for table `island`
--

CREATE TABLE `island`
(
    `id`          int(11) NOT NULL,
    `name`        varchar(255)  NOT NULL,
    `picture_url` varchar(1000) NOT NULL,
    `surface`     double        NOT NULL,
    `inhabitants` int(11) NOT NULL,
    `latitude`    double        NOT NULL,
    `longitude`   double        NOT NULL,
    `country`     varchar(255)  NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `island`
--
ALTER TABLE `island`
    ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `island`
--
ALTER TABLE `island`
    MODIFY `id` int (11) NOT NULL AUTO_INCREMENT;
